package model.entity;

import java.util.List;
import java.util.Objects;

public class Role {
    private Integer id;
    private String title;
    private String code;

    private List<PersonalRegData> personalRegData;

    public Role(Integer id, String title, String code, List<PersonalRegData> personalRegData) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.personalRegData = personalRegData;
    }

    public Role(Integer id, String title, String code) {
        this.id = id;
        this.title = title;
        this.code = code;
    }

    public Role(String title) {
        this.title = title;
    }

    public Role() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<PersonalRegData> getPersonalRegData() {
        return personalRegData;
    }

    public void setPersonalRegData(List<PersonalRegData> personalRegData) {
        this.personalRegData = personalRegData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) &&
                Objects.equals(title, role.title) &&
                Objects.equals(code, role.code) &&
                Objects.equals(personalRegData, role.personalRegData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, code, personalRegData);
    }
}
