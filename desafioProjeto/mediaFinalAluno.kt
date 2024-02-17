fun main() {
   val media = readLine()!!.toDouble();
   
   when {
       media < 5 -> println("REP")
       media > 7 -> println("APR")
       else -> println("REC")
   }
}