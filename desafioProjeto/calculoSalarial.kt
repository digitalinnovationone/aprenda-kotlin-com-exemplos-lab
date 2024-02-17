object ReceitaFederal {
  fun calcularImposto(salario: Double): Double {
  	val aliquota = when {
      (salario >= 0 && salario <= 1100) -> 0.05
      (salario > 1100.01 && salario <= 2500) -> 0.1
      (salario > 2500.01) ->0.15
      else -> throw IllegalArgumentException("Salário inválido")
    }
  	return aliquota * salario
  }
}

fun main() {
  val valorSalario = readLine()!!.toDouble();
  val valorBeneficios = readLine()!!.toDouble();
  
  val valorImposto = ReceitaFederal.calcularImposto(valorSalario);
  val saida = valorSalario - valorImposto + valorBeneficios;
  
  println(String.format("%.2f", saida));
}