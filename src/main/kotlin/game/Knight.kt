package game

/**
 * Knight 클래스
 * - 지상 유닛, 이동/공격/탑승 가능
 */
class Knight(name: String) : GameCharacter(name, UnitType.GROUND), Movable, Attacker, Passenger {

    override fun move(destination: Point) {
        System.out.println("${name}가 말을 타고 (${destination.x}, ${destination.y})로 이동합니다.")
    }

    override fun attack(target: GameCharacter) {
        if (target.unitType == UnitType.AIR) {
            // 날아다니는 캐릭터는 공격 불가
            System.out.println("${name}가 ${target.name}를 공격할 수 없습니다. (공중 유닛)")
        } else {
            // 지상 유닛 공격 (창으로 찌르기)
            System.out.println("${name}가 ${target.name}를 창으로 찌릅니다.")
        }
    }
}