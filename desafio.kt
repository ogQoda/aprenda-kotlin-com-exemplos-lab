// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val tecnologia: String) {
    override fun toString(): String {
        return "Nome: $nome\nDuracao: $duracao\nTecnologia: $tecnologia\n"
    }
}

data class Aluno(val nome: String, val idade: Int)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivelDeDificuldade: Nivel) {

    val listaDeAlunos: MutableList<Aluno> = mutableListOf<Aluno>()

    fun matricular(vararg alunos: Aluno) {
        for (aluno in alunos) {
            listaDeAlunos.add(aluno)
        }
    }

    fun listarAlunos(): List<Aluno> = listaDeAlunos

    fun listarConteudos(): String = conteudos.joinToString("\n")

    fun duracaoTotal(): Int {
        var duracaoDaFormacao: Int = 0
        for (c in conteudos) {
            duracaoDaFormacao += c.duracao ?: 0
        }
        return duracaoDaFormacao
    }
}

fun main() {
//    Instanciando conteúdos educacionais e lista contendo os mesmos
    val javaBasico: ConteudoEducacional = ConteudoEducacional("Introducao ao Java", 120, "Java")
    val cBasico: ConteudoEducacional = ConteudoEducacional("Introducao ao C", 240, "C")
    val sqlBasico: ConteudoEducacional = ConteudoEducacional(nome = "Intro SGBD", tecnologia = "MySQL")
    val kotlinBasico: ConteudoEducacional = ConteudoEducacional(nome = "Introducao Kotlin", tecnologia = "Kotlin")
    val conteudos: List<ConteudoEducacional> = listOf(javaBasico, cBasico, sqlBasico, kotlinBasico)

//    Instanciando Formação
    val formacaoKotlin: Formacao = Formacao("Formacao Kotlin", conteudos, Nivel.INTERMEDIARIO)

//    Instanciando um aluno
    var maria: Aluno = Aluno("Maria", 18)
    var joao: Aluno = Aluno("Joao", 25)
    var jose: Aluno = Aluno("Jose", 31)
    var ana: Aluno = Aluno("Ana", 22)

    var pedro: Aluno = Aluno("Pedro", 52)

//    Adicionando varios alunos à formação simultaneamente
    formacaoKotlin.matricular(maria, joao, jose, ana)
    formacaoKotlin.matricular(pedro)

//    Verificando alunos matriculados
    println(formacaoKotlin.listarAlunos())

//    Verificando conteudo da formacao
    println(formacaoKotlin.listarConteudos())

//    Verificando duracao total da formacao
    println("A ${formacaoKotlin.nome} possui duracao de ${formacaoKotlin.duracaoTotal()} minutos.")
}
