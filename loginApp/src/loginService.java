public class loginService {
    public boolean autenticate(String userId, String password){

         if (password == null || password.trim() == ""){
              return false;
         }
         return true;
    }
}
