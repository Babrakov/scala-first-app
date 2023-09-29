class Monads {
  val list = List(1, 2, 3, 4, 5)
  val list2 = List.fill(10)(100)
  val opt = Some(1)
  val opt2 = Some(5)


  //  for {
  //    l <- list
  //    l2 <- list2
  //  } yield println(l + l2)

  //  for {
  //    o <- opt
  //    o2 <- opt2
  //  } yield println(o + o2)

  //  Homework: why second for-comprehension is not compiled?

//  for {
//    l <- list
//    o <- opt
//  } yield println(l + o)
//  //
//  for {
//    o <- opt
//    l <- list
//  } yield (l + o)

}
