package sample.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;


@Entity
public class UserLogin {

    
    /**
     * represent the unique Id for the user.
     */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userLoginId;
    
    /**
     * property loginAttempts type integer.
     */
    private int loginAttempts;
    
    /**
     * holds userRole id for the user.
     */
    private int userRoleId;
    
    /**
     * holds the userIdentificationNo No of the user.
     */
    private String userIdentificationNo;
    
    /**
     * holds the user level of the user.
     */
    private String userLevel;
          
    /**
     * holds the password of the user.
     */
    @NotEmpty(message = "password is required.")
    private String password;
    
    /**
     * holds the email address for the user.
     */
    @Email(message = "Please provide a valid email address.")
    @NotEmpty(message = "Email is required.")
    @Column(unique=true, nullable = false)
    private String email;
    
    /**
     * holds firstName of the user.
     */
    @NotEmpty(message = "First name is required.")
    private String firstName;
    
    /**
     * holds last name of the user.
     */
    @NotEmpty(message = "Last name is required.")
    private String lastName;
    
    /**
     * holds the active status of the user.
     */
    private boolean status;
    
    /**
     * holds the password status of the user, whether system generated or not.
     */
    private boolean generatedPassword;
    
    /**
     * holds the current status of the user, whether he departures or not.
     */
    private boolean deleted;
    
    /**
     * The latest time that the object was modified.
     */
    private Date modifiedTime;
    

	public UserLogin(){
		
	}

	public UserLogin(UserLogin user) {
		
		this.userLoginId = user.userLoginId;
		this.loginAttempts = user.loginAttempts;
		this.userRoleId = user.userRoleId;
		this.userIdentificationNo = user.userIdentificationNo;
		this.userLevel = user.userLevel;
		this.password = user.password;
		this.email = user.email;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.status = user.status;
		this.generatedPassword = user.generatedPassword;
		this.deleted = user.deleted;
		this.modifiedTime = user.modifiedTime;
		
	}

	public long getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(long userLoginId) {
		this.userLoginId = userLoginId;
	}

	public int getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserIdentificationNo() {
		return userIdentificationNo;
	}

	public void setUserIdentificationNo(String userIdentificationNo) {
		this.userIdentificationNo = userIdentificationNo;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isGeneratedPassword() {
		return generatedPassword;
	}

	public void setGeneratedPassword(boolean generatedPassword) {
		this.generatedPassword = generatedPassword;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}  
    
    
    
}
