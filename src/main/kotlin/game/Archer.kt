package game

/**
 * Archer 클래스
 * - 지상 유닛, 이동/공격/탑승 가능
 */
class Archer(name: String) : GameCharacter(name, UnitType.GROUND), Movable, Attacker, Passenger {

    override fun move(destination: Point) {
        System.out.println("${name}가 걸어서 (${destination.x}, ${destination.y})로 이동합니다.")
    }

    override fun attack(target: GameCharacter) {
        // 땅, 하늘 모든 곳의 캐릭터를 공격 가능
        System.out.println("${name}가 ${target.name}를 화살로 공격합니다.")
    }
}