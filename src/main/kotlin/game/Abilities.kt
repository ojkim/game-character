package game

/** 이동 가능한 유닛이 구현합니다. */
interface Movable {
    fun move(destination: Point)
}

/** 공격 가능한 유닛이 구현합니다. */
interface Attacker {
    fun attack(target: GameCharacter)
}

/** 수송기에 탑승 가능한 유닛(역할)을 표시합니다. */
interface Passenger

/** 유닛을 수송하는 행동을 정의합니다. */
interface Transport {
    val capacity: Int
    fun load(passenger: Passenger)
    fun unload()
}