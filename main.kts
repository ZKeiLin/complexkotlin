println("UW Complex Kotlin homework")

// write a lambda using map and fold to solve "FIZZBUZZ" for the first fifteen numbers (0..15)
// use map to return a list with "", "FIZZ" or "BUZZ" as necessary
// use fold to compress the array of strings down into a single string
// the final string should look like FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ
//
val mapFoldResults = (1..15).map({num ->
    when {
        num % 15 == 0 -> "FIZZBUZZ";
        num % 3 == 0 -> "FIZZ";
        num % 5 == 0 -> "BUZZ";
        else -> "";
   }
}).fold(""){acc, item -> acc + item}


// This is a utility function for your use as you choose, and as an
// example of an extension method
fun Int.times(block: () -> Unit): Unit {
    for (it in 1..this) {
        block()
    }
}

// Use this function
fun process(message: String, block: (String) -> String): String {
    return ">>> ${message}: {" + block(message) + "}"
}
val r1 = process("FOO", {"BAR"}) // call process() with message "FOO" and a block that returns "BAR"

val r2_message = "wooga"
val r2 = process("FOO", {r2_message.toUpperCase().repeat(3)}) // call process() with message "FOO" and a block that upper-cases 
            // r2_message, and repeats it three times with no spaces: "WOOGAWOOGAWOOGA"


// write an enum-based state machine between talking and thinking
/*
This is going to be a peculiar use of enum, 
however, as we are going to model a very simple state machine: a
s everybody knows, 
philosophers split their time between 
THINKING and TALKING, 
and only shift from one state to the other when told to do so via the method call signal. 
Additionally, each state should override the toString function so that 
when THINKING, a philosopher will return "Deep thoughts..." and
when TALKING, a philosopher will return "Allow me to suggest an idea...". 
If you are not sure of the syntax here, check out the Kotlin reference page on Enum classes. 
Modeling state machines in a mobile application is a very common occurrence, so it's worth taking the time to give this exercise a shot.
 */
enum class Philosopher { 
    THINKING {
        override fun signal() = TALKING;
        override fun toString() = "Deep thoughts...."
    },

    TALKING {
        override fun signal() = THINKING;
        override fun toString() = "Allow me to suggest an idea..."
    };

    abstract fun signal(): Philosopher
}

// create an class "Command" that can be used as a function (provide an "invoke()" function)
// that takes a single parameter ("message" of type String)
// primary constructor should take a String argument ("prompt")
// when called, the Command object should return a String containing the prompt and then the message

class Command(val prompt: String) {
    operator fun invoke(message:String):String {
        return prompt+message
    }
}




// ================================
println("map fold test: " + if (mapFoldResults == "FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ") "." else "!")

println("r1 test: " + if (r1 == ">>> FOO: {BAR}") "." else "!")

println("r2 test: " + if (r2 == ">>> FOO: {WOOGAWOOGAWOOGA}") "." else "!")

var seneca = Philosopher.THINKING
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")
print("Seneca, think! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Deep thoughts....") "." else "!")
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")


print("Command tests: ")
print(if (Command("")("") == "") "." else "!")
print(if (Command("> ")("Hello!") == "> Hello!") "." else "!")
println("")



