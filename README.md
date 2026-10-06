# spring-hello

```bash
./gradlew bootRun
curl http://localhost:8080/api/hello
```

## 권한 오류 발생시

```bash
./gradlew: Permission denied
```

```bash
git update-index --chmod=+x gradlew
git commit -m "gradlew 실행 권한 추가"
git push
```
