package org.example.controller;


import org.example.config.AuthToken;
import org.example.config.Constants;
import org.example.config.JwtTokenUtil;
import org.example.dto.ResponseDto;
import org.example.entity.EmployeeEntity;
import org.example.entity.RolesEntity;
import org.example.entity.enumdata.ActiveStatus;
import org.example.exceptions.ErrorResponse;
import org.example.exceptions.ProductException;
import org.example.service.EmployeeService;
import org.example.service.RolesService;
import org.example.user.LoginUser;
import org.example.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private final AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private Environment env;
    @Autowired
    private EmployeeService employeeService;

    private final RolesService rolesService;


    public IndexController(AuthenticationManager authenticationManager, RolesService rolesService) {
        this.authenticationManager = authenticationManager;
        this.rolesService = rolesService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginUser loginUser) {

        try {
            final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUserName(),loginUser.getPassword()));
            // get user by email in AD
            final EmployeeEntity user = employeeService.getUserByEmail(authentication.getName());
            if(user == null){
                ErrorResponse error = new ErrorResponse(Constant.ErrorType.LOGIN_USER_NOT_FOUND, Constant.Message.LOGIN_USER_NOT_FOUND, Constant.Code.BAD_REQUEST);
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
            }
            if(user.getStatus() == ActiveStatus.INACTIVE){
                throw new ProductException(new ErrorResponse(Constant.ErrorType.USER_DEACTIVATED, Constant.Message.USER_DEACTIVE));
            }
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String token = jwtTokenUtil.generateToken(user);
            AuthToken authToken = new AuthToken(token, user.getEmail(), Constants.ACCESS_TOKEN_VALIDITY_SECONDS,
                    user.getId());
            String fullName = user.getFirstName() + " " + user.getLastName();
            authToken.setFullName(fullName);
            authToken.setRoleId(user.getRoleId());
            RolesEntity currentLoginRole = rolesService.getRoleById(user.getRoleId());
            authToken.setRoleName(currentLoginRole.getRoleName());
            ResponseDto<AuthToken> response = new ResponseDto<>();
            response.setErrorMessage(Constant.Message.SUCCESS);
            response.setContent(authToken);
            response.setStatusCode(Constant.Code.SUCCESS);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            ErrorResponse error = new ErrorResponse(e.getClass().getSimpleName(),e.getMessage(), Constant.Code.BAD_REQUEST);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

    }

}
