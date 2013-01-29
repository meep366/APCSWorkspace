/**
 * Specifies methods for registering and logging in users.
 */
public interface Login
{
  /**
   * Tries to register a new user with a given screen name
   * and password;
   * @param name the screen name of the user.
   * @param password the password for the user.
   * @return 0 if successful, or an error code (a negative integer) if failed:<br>
   * -1 -- invalid screen name (must be 4-10 chars)<br>
   * -2 -- invalid password (must be 2-10 chars)<br>
   * -3 -- the screen name is already taken.
   */
  int addUser(String name, String password);

  /**
   * Tries to login a user with a given screen name and password;
   * @param name the screen name of the user.
   * @param password the password for the user.
   * @return 0 if successful, or an error code (a negative integer) if failed:<br>
   * -1 -- screen name not found<br>
   * -2 -- invalid password<br>
   * -3 -- user is already logged in.
   */
  int login(String name, String password);
}
