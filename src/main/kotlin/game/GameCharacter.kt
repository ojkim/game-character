package game

/**
 * 모든 유닛의 기본 클래스입니다.
 * 공통 속성으로 '이름(name)'과 '유닛 유형(unitType)'을 가집니다.
 */
abstract class GameCharacter(val name: String, val unitType: UnitType)