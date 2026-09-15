package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor


public class Account {
    private int accountId;
    private String email;
    private String userName;
    private String fullName;
    private Department department;
    private Position position;
    private LocalDate createDate;

    public Account(int accountId, String email, String userName, String fullName, Department department, Position position, LocalDate createDate) {
        this.accountId = accountId;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.department = department;
        this.position = position;
        this.createDate = createDate;
    }

}
