package variables

object NewTypes {

    /// 1 - literal types
    val aNumber = 3
    val three: 3 = 3 // 3 <: Int

    def passNumber(n: Int) = println(n)
    passNumber(45)
    passNumber(three)

    def passStrict(n: 3) = println(n)
    passStrict(three)
    //passStrict(45) not ok func passStrict Mandatory parameter n = 3

    val pi: 3.14 = 3.14
    val truth: true = true
    val myFavoriteLanguage: "Scala" = "Scala"

    def doSomethingWithYourLife(meaning: Option[Int]) = meaning.foreach(println)

    /// 2 - union types
    def ambivalentMethod(arg: String | Int) = arg match
        case _: String => println(s"a string: $arg")
        case _: Int => println(s"an int: $arg")

    ambivalentMethod(42)
    ambivalentMethod("Scala")

    val stringOrInt = if (43 > 0) "a string" else 43
    val aStringOrInt: String | Int = if (43 > 0) "a string" else 43

    /// 3- intersection types
    trait Camera {
        def use() = println("snap")
    }
    trait Phone {
        def use() = println("ring")
    }

    def useSmartDevice(sp: Camera & Phone) = {
        sp.use()
    }

    class Smartphone extends Camera with Phone {
        override def use(): Unit = println("smart")
    }
    useSmartDevice(new Smartphone)

    trait  HostConfig
    trait HostController {
        def get: Option[HostConfig]
    }

    trait PortConfig
    trait PortController {
        def get: Option[PortConfig]
    }

    def getConfigs(controller: HostController & PortController): Option[HostConfig & PortConfig] = controller.get
}