package kg.geeks.game.players

import kg.geeks.game.logic.RPG_Game

class Boss(health: Int, damage: Int, name: String) : GameEntity(health, damage, name) {
    var defence: SuperAbility? = null

    fun chooseDefence() {
        val variants = SuperAbility.values()
        defence = variants[RPG_Game.random.nextInt(variants.size)]
    }

    fun attack(heroes: Array<Hero>) {
        for (hero in heroes) {
            if (hero.health > 0) {
                if (hero is Berserk && this.defence != SuperAbility.BLOCK_DAMAGE_REVERT) {
                    val blocked = (RPG_Game.random.nextInt(2) + 1) * 5
                    hero.setBlockedDamage(blocked)
                    hero.health -= (this.damage - blocked)
                } else {
                    hero.health -= this.damage
                }
            }
        }
    }

    override fun toString(): String {
        return "BOSS $name health: $health damage: $damage defence: $defence"
    }
}
