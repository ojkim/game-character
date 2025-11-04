package game

/**
 * Shuttle 클래스
 * - 공중 유닛 (FlyingUnit 상속), 이동/수송 가능
 */
class Shuttle(name: String) : FlyingUnit(name), Transport {
    // move()는 FlyingUnit으로부터 자동 상속 (코드 재사용)

    override val capacity = 8 // 최대 8기
    private val passengers = mutableListOf<Passenger>() // 탑승자 목록

    /**
     * 유닛을 셔틀에 태웁니다.
     * [Passenger] 인터페이스를 구현한 유닛만 탑승 가능합니다.
     */
    override fun load(passenger: Passenger) {
        if (passengers.size < capacity) {
            if (passenger is GameCharacter) { // 이름 출력을 위해 GameCharacter로 형 변환
                passengers.add(passenger)
                System.out.println("${passenger.name}가 ${this.name}에 탑승합니다.")
            }
        } else {
            System.out.println("${this.name}가 꽉 찼습니다.")
        }
    }

    /**
     * 셔틀의 모든 승객을 내립니다.
     */
    override fun unload() {
        System.out.println("${this.name}가 모든 승객을 내립니다:")
        passengers.forEach { passenger ->
            if (passenger is GameCharacter) {
                System.out.println("${passenger.name}가 내립니다.")
            }
        }
        passengers.clear()
    }
}