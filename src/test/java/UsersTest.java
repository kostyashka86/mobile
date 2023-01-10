import pages.UsersPage;
import extensions.AppiumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AppiumExtension.class)
public class UsersTest {

    @Test
    public void checkRandomUser() {
        new UsersPage()
                .open()
                .checkUserPage()
                .clickUserPage()
                .checkUsersOnUserPage();
    }
}
