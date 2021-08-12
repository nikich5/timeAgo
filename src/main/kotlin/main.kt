import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    while(true) {
        println("Введите количество минут, с момента выхода пользователя из сети")
        val seconds = scanner.nextInt() * 60
        println(agoToText(seconds))
    }
}

fun agoToText(seconds: Int): String {
    return when {
        seconds in 0..60 -> "был(а) только что"
        seconds in 61..3_600 -> "был(а) ${minutesFormatting(seconds)} назад"
        seconds in 3_601..86_400 -> "был(а) ${hoursFormatting(seconds)} назад"
        seconds in 86_401..172_800 -> "был(а) в сети сегодня"
        seconds in 172_801..259_200 -> "был(а) в сети вчера"
        seconds >= 259_201 -> "был(а) в сети давно"
        else -> "Некорректное значение"
    }
}

fun minutesFormatting(seconds: Int): String {
    val minutes = seconds / 60
    return when {
        (minutes % 100) == 11 || (minutes % 100) == 12 || (minutes % 100) == 13 || (minutes % 100) == 14
        -> "$minutes минут"
        (minutes % 10) == 1 -> "$minutes минуту"
        (minutes % 10) == 2 || (minutes % 10) == 3 || (minutes % 10) == 4 -> "$minutes минуты"
        else -> "$minutes минут"
    }
}

fun hoursFormatting(seconds: Int): String {
    val hours = seconds / 3_600
    return when {
        (hours % 100) == 11 || (hours % 100) == 12 || (hours % 100) == 13 || (hours % 100) == 14
        -> "$hours часов"
        (hours % 10) == 1 -> "$hours час"
        (hours % 10) == 2 || (hours % 10) == 3 || (hours % 10) == 4 -> "$hours часа"
        else -> "$hours часов"
    }
}