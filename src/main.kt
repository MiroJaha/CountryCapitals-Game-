import kotlin.random.Random

fun main(){

    class Country (var name:String,var capital:String){
        fun print(){
            println("The Capital of $name is $capital\n")
        }
    }

    val countries= arrayListOf<Country>()
    countries.add(Country("Saudi Arabia","Riyadh"))
    countries.add(Country("USA","Washington"))
    countries.add(Country("UAE","Abu Dhabi"))
    countries.add(Country("Indonesia","Jakarta"))
    countries.add(Country("Malaysia","Kuala"))
    countries.add(Country("Philippines","Malina"))
    countries.add(Country("Switzerland","Bern"))
    countries.add(Country("Brazil","Brasilia"))
    countries.add(Country("India","New Delhi"))
    countries.add(Country("France","Paris"))

    var count=0
    var correctAnswers=0

    var countAllCountries=0
    val norepeat=arrayListOf<Int>()

    while(true) {
        while(count<3&&countAllCountries<10){
            var random:Int
            while(true) {
                random = Random.nextInt(10)
                if(!norepeat.contains(random))
                    break
            }
            norepeat.add(random)
            print("Please Guess Tha Capital of ${countries[random].name}: ")
            val capital= readLine()!!
            if(capital.isEmpty()){
                println("\nPlease Enter Valid Name\n")
                continue
            }
            else if(countries[random].capital==capital){
                println("Correct Answer!!")
                countries[random].print()
                correctAnswers++
            }
            else {
                println("Wrong Answer :(")
                countries[random].print()
            }
            count++
            countAllCountries++
            if(count>=3||countAllCountries>=10)
                println("You Answered $correctAnswers Correct Answers out of $count\n")
        }

        if(countAllCountries>=10) {
            println("This Is All The Countries That We Have, Thank You")
            println("\nHope You Enjoyed\nHave Great Day")
            break
        }

        print("Would You Like to Play Again (y/n): ")
        val answer= readLine()!!
        if(answer=="n"){
            println("\nHope You Enjoyed\nHave Great Day")
            break
        }
        else if(answer=="y")
            count=0
        else
            println("\nPlease Enter (y) for Yes or (n) for NO\n")
    }
}