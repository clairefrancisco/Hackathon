package StockManagement

//Interface
interface UserActions {
    fun view(){
        FruitTypes.listOfFruits.forEach{ type ->
            println("${type.key.uppercase()} fruits:")
            type.value.forEach{ fruit ->
                println("\t Fruit Name: ${fruit.key}")
                println("\t Quantity: ${fruit.value}")
            }

        }
    }
    fun update(permission: Boolean){
    if(permission){
        println("Types of fruits available:")
        FruitTypes.listOfFruits.forEach{ type ->
            println("\t - ${type.key.first().uppercaseChar() + type.key.substring(1).lowercase()}")
        }

        print("\nPlease select type of fruit: ")
        var selectedType = readLine()!!.lowercase()

        if(FruitTypes.listOfFruits.containsKey(selectedType)){
            var retrievedFruits = FruitTypes.listOfFruits.filter { it.key.lowercase() == selectedType }.values.first()
            retrievedFruits.forEach{ fruit ->
                println("\t Fruit Name: ${fruit.key.first().uppercaseChar() + fruit.key.substring(1).lowercase()}")
                println("\t Quantity: ${fruit.value}")
            }

            print("\nPlease select type of fruit: ")
            var selectedFruit = readLine()!!.lowercase()

            if(retrievedFruits.containsKey(selectedFruit)){
                print("Please enter the new quantity: ")
                var quantity = readLine()!!.toInt()
                retrievedFruits.replace(selectedFruit, quantity)
                println("$selectedFruit Fruit Quantity updated to $quantity .")
            }
            else println("Fruit doesn't exists.")
        }
        else println("\nType of fruit doesn't exists.")
    }
    else println("You don't have permission to update.")
     }

     fun add(permission: Boolean) {
         if (permission) {
             println("Types of fruits available:")
             FruitTypes.listOfFruits.forEach { type ->
                 println("\t - ${type.key.first().uppercaseChar() + type.key.substring(1).lowercase()}")
             }

             print("\nPlease select type of fruit: ")
             var selectedType = readLine()!!.lowercase()

             if (FruitTypes.listOfFruits.containsKey(selectedType)) {
                 var retrievedFruits =
                     FruitTypes.listOfFruits.filter { it.key.lowercase() == selectedType }.values.first()
                 println("List of Fruit Products in the Inventory")
                 retrievedFruits.forEach { fruit ->
                     println("\t Fruit Name: ${fruit.key.first().uppercaseChar() + fruit.key.substring(1).lowercase()}")
                     println("\t Quantity: ${fruit.value}")
                 }
                 print("Enter Name of Fruit: ")
                 var inputFruit = readLine()!!.lowercase()
                 if (retrievedFruits.containsKey(inputFruit)) {
                     println("$inputFruit Already Exist")
                 } else {
                     print("Enter Quantity: ")
                     var quantity = readLine()!!.toInt()
                     retrievedFruits.put(inputFruit, quantity)
                     println("New $inputFruit Fruit Product Successfully Added with quantity of $quantity")
                 }
             } else {
                 print("No Type of Fruit Name Instance")
             }
         }
         else println("You don't have permission to add.")
     }

    fun delete(permission: Boolean) {
        if (permission) {
            println("Types of fruits available:")
            FruitTypes.listOfFruits.forEach { type ->
                println("\t - ${type.key.first().uppercaseChar() + type.key.substring(1).lowercase()}")
            }
            print("\nPlease select type of fruit to view Inventory List: ")
            var selectedType = readLine()!!.lowercase()

            if (FruitTypes.listOfFruits.containsKey(selectedType)) {
                var retrievedFruits =
                    FruitTypes.listOfFruits.filter { it.key.lowercase() == selectedType }.values.first()
                println("List of Fruit Products in the Inventory")
                retrievedFruits.forEach { fruit ->
                    println("\t Fruit Name: ${fruit.key.first().uppercaseChar() + fruit.key.substring(1).lowercase()}")
                    println("\t Quantity: ${fruit.value}")
                }
                print("Enter Name of Fruit you want to remove: ")
                var inputFruit = readLine()!!.lowercase()
                if (retrievedFruits.containsKey(inputFruit)) {
                    retrievedFruits.remove(inputFruit)
                    println("$inputFruit Product Successfully Deleted")
                } else {
                    println("$inputFruit Name Does not Exist!")
                }
            } else {
                println("\n $selectedType of fruit doesn't exists.")
            }
        }
        else println("You don't have permission to delete.")
    }

}