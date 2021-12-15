import StockManagement.Permission

//Inheritance and Polymorph
class Staff() : User() {
    private val userName: String = "employeeStaff"
    private val password: String = "passwordStaff"
    private val isAdmin: Permission = Permission(false)

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