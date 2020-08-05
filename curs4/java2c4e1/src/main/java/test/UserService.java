package test;

public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void sayHello() {
        userRepo.printHello();
    }
}
