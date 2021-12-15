import StockManagement.Permission

//Inheritance and Polymorph
class Admin() : User() {

    private val userName: String = "usernameAdmin"
    private val password: String = "passwordAdmin"
    private val isAdmin: Permission = Permission(true)

    override fun getUserName(): String {
        return this.userName
    }

    override fun getPassword(): String {
        return this.password
    }

    override fun getPermission():Boolean{
        return this.isAdmin.component1()
    }
}