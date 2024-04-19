import api from "./api";

class UserService {
    
    getUserByEmail(email){
        return api
        .get("/user/email/"+email)
        .then(response => {
          return response.data;
        })
        .catch(error => {
            console.error("Error getting user:", error);
            throw error; // Rethrow the error to handle it in the caller
        });
    }

    getUserById(id){
        return api
        .get("/user/"+id)
        .then(response => {
          return response.data;
        })
        .catch(error => {
            console.error("Error getting user:", error);
            throw error; // Rethrow the error to handle it in the caller
        });
    }


    getAllUsers(){
        return api
        .get("/user/")
        .then(response => {
            return response.data;
        })
        .catch(error => {
            console.error("Error getting users:", error);
            throw error; // Rethrow the error to handle it in the caller
        });
    }

    editUserRole(id,role){
        return api
        .put("/user/"+id,{
            role
        })
        .then(response => {
            return response.data;
        })
        .catch(error => {
            console.error("Error editing user role:", error);
            throw error; // Rethrow the error to handle it in the caller
        });
    }

    getAllRoles(){
        return api
        .get("/user/getAllRoles")
        .then(response => {
            return response.data;
        })
        .catch(error => {
            console.error("Error getting roles:", error);
            throw error; // Rethrow the error to handle it in the caller
        });
    }

}

export default new UserService() ;