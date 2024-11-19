package kg.geeks.game.players

class Magic(health: Int, damage: Int, name: String) : Hero(health, damage, name, SuperAbility.BOOST) {
    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        // Implement boosting logic
    }
}