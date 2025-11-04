package game

// ========== 4. 시나리오 실행 (main 함수) ==========

fun main() {
    System.out.println("--- 1. 유닛 생성 및 셔틀 탑승 ---")

    // Knight 16기, Archer 16기 생성
    val knights = List(16) { i -> Knight("Knight${i + 1}") }
    val archers = List(16) { i -> Archer("Archer${i + 1}") }

    // Shuttle 4기 생성
    val shuttles = List(4) { i -> Shuttle("Shuttle${i + 1}") }

    // Griffin 5기 생성
    val griffins = List(5) { i -> Griffin("Griffin${i + 1}") }

    // 셔틀 4대에 16쌍(K+A) 나눠 태우기
    (knights.zip(archers)).chunked(4).forEachIndexed { shuttleIndex, pairs ->
        val shuttle = shuttles[shuttleIndex]
        pairs.forEach { (knight, archer) ->
            shuttle.load(knight) // Passenger 타입이라 탑승 가능
            shuttle.load(archer) // Passenger 타입이라 탑승 가능
        }
    }

    System.out.println("\n--- 2. 유닛 이동 ---")
    val destination = Point(10, 10) // 이동할 목표 지점

    // 셔틀 4기와 그리핀 5기 이동
    val allFlyingUnits: List<Movable> = shuttles + griffins
    allFlyingUnits.forEach { unit ->
        unit.move(destination)
    }

    System.out.println("\n--- 3. 셔틀에서 내리기 ---")
    shuttles.forEach { it.unload() }

    System.out.println("\n--- 4. Knight 공격 테스트 ---")
    val attackerKnight = knights[0] // Knight1
    attackerKnight.attack(knights[1])     // -> Knight2 (지상)
    attackerKnight.attack(archers[0])     // -> Archer1 (지상)
    attackerKnight.attack(griffins[0])    // -> Griffin1 (공중)
    attackerKnight.attack(shuttles[0])    // -> Shuttle1 (공중)

    System.out.println("\n--- 5. Archer 공격 테스트 ---")
    val attackerArcher = archers[0] // Archer1
    attackerArcher.attack(archers[1])     // -> Archer2 (지상)
    attackerArcher.attack(knights[1])     // -> Knight2 (지상)
    attackerArcher.attack(griffins[0])    // -> Griffin1 (공중)
    attackerArcher.attack(shuttles[0])    // -> Shuttle1 (공중)

    System.out.println("\n--- 6. Griffin 공격 테스트 ---")
    val attackerGriffin = griffins[0] // Griffin1
    attackerGriffin.attack(griffins[1])    // -> Griffin2 (공중)
    attackerGriffin.attack(archers[0])     // -> Archer1 (지상)
    attackerGriffin.attack(knights[1])     // -> Knight2 (지상)
    attackerGriffin.attack(shuttles[0])    // -> Shuttle1 (공중)
}