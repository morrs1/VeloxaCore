DC = docker compose

.PHONY: kafka mongo all

#Общие технологии
kafka:
	cd kafka && $(DC) --env-file .env -f docker-compose-kafka.yaml up --build -d
kafka-down:
	cd kafka && $(DC) --env-file .env -f docker-compose-kafka.yaml down

#Team environment
mongo:
	cd db/mongo && $(DC) --env-file .env -f docker-compose-mongo.yaml up --build -d
mongo-down:
	cd db/mongo && $(DC) --env-file .env -f docker-compose-mongo.yaml down

#User environment
user-postgres:
	cd veloxa-user-microservice/db/postgres && $(DC) --env-file .env -f docker-compose-postgres-user-microservice.yaml up --build -d
user-postgres-down:
	cd veloxa-user-microservice/db/postgres && $(DC) --env-file .env -f docker-compose-postgres-user-microservice.yaml down

#Meeting environment
meeting-postgres:
	cd veloxa-meeting-microservice/db/postgres && $(DC) --env-file .env -f docker-compose-postgres-meeting-microservice.yaml up --build -d
meeting-postgres-down:
	cd veloxa-meeting-microservice/db/postgres && $(DC) --env-file .env -f docker-compose-postgres-meeting-microservice.yaml down

all: kafka mongo user-postgres meeting-postgres
all-down: kafka-down mongo-down user-postgres-down meeting-postgres-down
