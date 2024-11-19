package kg.geeks.game.players

abstract class Hero(health: Int, damage: Int, name: String, val ability: SuperAbility) : GameEntity(health, damage, name) {
    fun attack(boss: Boss) {
        boss.health -= this.damage
    }

    abstract fun applySuperPower(boss: Boss, heroes: Array<Hero>)

    fun takeDamage(damage: Int) {
        this.health -= damage
        if (this.health <= 0) {
            println("$name died.")
        }
    }
}