# inside
1. Приложение запускается на 8081 порту.
2. В папке messages есть докер файл для сборки имеджа.
3. Собранные имедж можно скачать с https://disk.yandex.ru/d/qm1RyMSnYLx8zA
4. Для реализации были использованы следующие адреса:
	1. /auth/registration - post запрос формат {
   name: "имя отправителя"
   password: "пароль"
	} - регистрирует нового пользователя
	2. /auth/login - post формат как в регистрации, проверяет пароль и отдает токен
	3. /message - post, формат {
   name:       "имя отправителя",
   message:    "текст сообщение"
} - так же если сюда отправить {
   name:       "имя отправителя",
   message:    "history 10"
} - вернуться последнии 10 сообщений
5. для авторизации проверяется заголовок Authorization и токен вида "Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGV4IiwiaWF0IjoxNjQwNzgxNTU5LCJleHAiOjE2NDA5NTQzNTl9.pABVdXdAP13rGLH1yKqA8e3y8TbLDqneCL-p4HxegGA"
6. Для реализации задачи использловал spring boot
7. Надеюсь задачу понял правильно и ничего не упустил при реализации.