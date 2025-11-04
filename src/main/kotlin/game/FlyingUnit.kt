package game

/**
 * 날아다니는 유닛(Shuttle, Griffin)의 공통 부모입니다.
 * 이들은 '날아서' 이동하는 방식이 동일하므로,
 * 'move' 메서드를 미리 구현하여 코드 중복을 제거합니다. (재사용성)
 */
abstract class FlyingUnit(name: String) : GameCharacter(name, UnitType.AIR), Movable {
    // [Shuttle]과 [Griffin]의 공통 이동 로직
    override fun move(destination: Point) {
        System.out.println("${name}가 날아서 (${destination.x}, ${destination.y})로 이동합니다.")
    }
}