DC = docker compose

.PHONY: kafka mongo

kafka:
	cd kafka && $(DC) --env-file .env -f docker-compose-kafka.yaml up --build -d
kafka-down:
	cd kafka && $(DC) --env-file .env -f docker-compose-kafka.yaml down

mongo:
	cd db/mongo && $(DC) --env-file .env -f docker-compose-mongo.yaml up --build -d
mongo-down:
	cd db/mongo && $(DC) --env-file .env -f docker-compose-mongo.yaml down
