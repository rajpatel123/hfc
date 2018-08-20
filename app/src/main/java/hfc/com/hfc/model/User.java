package hfc.com.hfc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("PhoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("EmailAddress")
    @Expose
    private String emailAddress;
    @SerializedName("Password")
    @Expose
    private Object password;
    @SerializedName("PasswordSalt")
    @Expose
    private String passwordSalt;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("PinCode")
    @Expose
    private Integer pinCode;
    @SerializedName("ReferalCode")
    @Expose
    private Object referalCode;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("IsDelete")
    @Expose
    private Object isDelete;
    @SerializedName("CreatedBy")
    @Expose
    private Integer createdBy;
    @SerializedName("CreatedOn")
    @Expose
    private String createdOn;
    @SerializedName("ModifiedBy")
    @Expose
    private Object modifiedBy;
    @SerializedName("ModifiedOn")
    @Expose
    private Object modifiedOn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public Object getReferalCode() {
        return referalCode;
    }

    public void setReferalCode(Object referalCode) {
        this.referalCode = referalCode;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Object getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Object isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Object getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Object modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Object getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Object modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
