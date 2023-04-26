# [프로젝트] Spring Boot 상품 관리, 주문관리 API 구현
## 프로젝트 소개 😎

### 상품관리 API

#### ☕ 기능

- 커피 상품 등록
- 커피 상품 정보 제공
- 커피 상품 정보 수정
- 커피 상품 삭제

#### 🍋 API 설계

1. 커피 정보 반환(GET): /product/coffee/{cid}

2. 커피 정보 등록(POST) : /product/coffee

3. 커피 정보 수정(PUT) : /product/coffee

4. 커피 정보 삭제(DELETE) : /product/coffee/{cid}



### 주문 관리 API

#### ☕ 기능

- 커피 주문
- 커피 주문 정보 제공
- 커피 주문 정보 삭제


#### 🍋 API 설계

1. 주문 정보 반환(GET): /order

2. 주문 정보 등록(주문하기)(POST) : /order

3. 주문 정보 삭제(주문취소)(DELETE) : /order

<br>

### Entity 설계

**coffee**
| 필드 | 타입 |
| --- | --- |
| cid | UUID |
| name | String |
| price | Long |
| origin | String |
| producer | String |
| created_time | LocalDateTime |


**order_tb**
| 필드 | 타입 |  |
| --- | --- | --- |
| oid | Long | PK |
| total_price | Long |  |
| total_number | Long |  |
| created_time | LocalDateTime |  |

**coffee_order**

| 필드 | 타입 |  |
| --- | --- | --- |
| caoid | Long | PK |
| oid | Long | FK(order_tb) |
| cid | UUID | FK(coffee) |
| count | Long |  |


### 기술
Spring, Spring Boot, JPA, MySQL

