package game

/**
 * Griffin 클래스
 * - 공중 유닛 (FlyingUnit 상속), 이동/공격 가능
 */
class Griffin(name: String) : FlyingUnit(name), Attacker {
    // move()는 FlyingUnit으로부터 자동 상속 (코드 재사용)

    override fun attack(target: GameCharacter) {
        if (target.unitType == UnitType.AIR) {
            // 날아다니는 캐릭터는 공격 불가
            System.out.println("${name}가 ${target.name}를 공격할 수 없습니다. (공중 유닛)")
        } else {
            // 땅으로 번개
            System.out.println("${name}가 ${target.name}에게 번개를 내리칩니다.")
        }
    }
}