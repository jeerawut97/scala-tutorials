import variables.NewTypes.*

@main def hello: Unit =
  println("Hello world!")
  println(msg)
  println("import ambivalentMethod(42): "+ambivalentMethod(42))

def msg = "I was compiled by Scala 3. :)"
