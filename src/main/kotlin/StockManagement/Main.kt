package StockManagement

import Admin
import Staff
import User
import loginMessage
import logoutMessage

fun main(){
     userLogin()
}

//user validation
fun userLogin(){
    val user1 = Admin()
    val userNameAdmin = user1.getUserName()
    val user1password = user1.getPassword()

    val user2 = Staff()
    val userNameStaff= user2.getUserName()
    val user2password = user2.getPassword()

    var userName = ""
    var password = ""

    println("Enter username:")
    userName = readLine()!!

    println("Enter password:")
    password = readLine()!!

    if(userName == userNameAdmin && password == user1password){

        homeMenu(Admin())
    }
    else if(userName == userNameStaff && password == user2password){
        homeMenu(Staff())
    }
    else {
        println("Invalid username and password.")
        println("Enter username:")
        userName = readLine()!!

        println("Enter password:")
        password = readLine()!!
    }


}

// shows menu of the user
fun homeMenu(user: User){

        val menu: Map<Int, String> = mapOf(
            1 to "View List of Fruits",
            2 to "Update Quantity",
            3 to "Add new Fruit",
            4 to "Remove Fruit",
            0 to "Exit",
        )

    val permission: Boolean = user.getPermission()
    user.loginMessage()
        do {
            println("\nPlease select an action:")
            menu.map {
                println("${it.key} - ${it.value}")
            }
            print("Enter the number of your action: ")
            var userChoice = readLine()!!.toInt()

            when(userChoice) {
                1 -> user.view()
                2 -> user.update(permission)
                3 -> user.add(permission)
                4 -> user.delete(permission)
                0 -> {
                    user.logoutMessage()
                    break
                }
                else -> println("\nInvalid input.")
            }

        }while(userChoice != 0)

    }

