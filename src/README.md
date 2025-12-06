1. 기능
   1) 쇼핑몰 도메인 + 결제 및 정산을 목표로 점진적 기능 추가
   2) 권한처리 + 세션유지(JWT는 복잡해지니 우선 빠르게 세션으로)

2. DB
   1) memoryRDBMS == 데이터 영속성 없음.
   2) 삭제는 softDelete로 대체


3. 데이터 모델 규칙
   1) api 접근은 ReqDTO로 vaildation 및 Swagger 문서를 담당
   2) 
