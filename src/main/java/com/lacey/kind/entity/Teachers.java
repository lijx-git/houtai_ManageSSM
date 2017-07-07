package com.lacey.kind.entity;

/**
 * Created by Administrator on 2017/6/6.
 */
public class Teachers {
    private Long tid; //工号
    private String tname;
    private String gender;
    private String birthday;
    private String IDNumber;//身份证号
    private String address;//住址

    @Override
    public String toString() {
        return "Teachers{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", IDNumber='" + IDNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Teachers(Long tid, String tname, String gender, String birthday, String IDNumber, String address) {
        this.tid = tid;
        this.tname = tname;
        this.gender = gender;
        this.birthday = birthday;
        this.IDNumber = IDNumber;
        this.address = address;
    }

    public Teachers() {
        super();
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
