env-up: ## todo: comment this line
	docker-compose -f docker/dependencies-compose.yaml up -d
env-down: ## todo: comment this line
	docker-compose -f docker/dependencies-compose.yaml down
env-stop: ## todo: comment this line
	docker-compose -f docker/dependencies-compose.yaml stop