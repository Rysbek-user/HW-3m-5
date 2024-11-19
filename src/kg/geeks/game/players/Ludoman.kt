package kg.geeks.game.players

import kotlin.random.Random

class Ludoman(name: String, health: Int, damage: Int) : Hero(health, damage, name, SuperAbility.DICE_STRIKE) {
    private val random = Random

    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        // No implementation needed
    }

    fun useSuperAbility(boss: Hero) {
        val die1 = rollDie()
        val die2 = rollDie()
        println("Лудоман бросает две игральные кости: $die1 и $die2")
        if (die1 == die2) {
            val damageToBoss = die1 * die2
            println("Выпали одинаковые числа! Лудоман отнимает $damageToBoss здоровья у босса.")
            boss.takeDamage(damageToBoss)
        } else {
            val damageToTeammate = die1 + die2
            val randomTeammate = getRandomTeammate()
            println("Выпали разные числа. Лудоман отнимает $damageToTeammate здоровья у ${randomTeammate?.name}.")
            randomTeammate?.takeDamage(damageToTeammate)
        }
    }

    private fun rollDie(): Int = random.nextInt(6) + 1

    private fun getRandomTeammate(): Hero? {
        // Implement logic to return a random teammate from heroes
        return null
    }
}