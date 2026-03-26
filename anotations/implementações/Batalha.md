Implementar batalha de forma dirigida a eventos e não com loop a cada x ms.

Idéia:

- A batalha contem uma timeline entre 0 e 3 minutos
- essa *timeline* será como um vetor eventos apontando para o momento X
- o serviço de calculo gera os eventos iniciais e percorre essa *timeline


## Issue criada pelo GPT para X1:

# ⚔️ Issue: Implementação de Batalha Simples (2 Personagens, Tempo Contínuo)

## 🎯 Objetivo

Implementar um sistema de batalha backend entre **2 personagens (1v1)** com execução em **tempo contínuo**, incluindo:

- dano automático (ataque básico)
    
- geração de energia ao longo do tempo
    
- uso automático de skill ao atingir energia máxima
    

---

# 📦 Escopo (MVP)

- 2 unidades (Player vs Enemy)
    
- Sem múltiplos alvos
    
- Sem buffs/debuffs complexos
    
- Sem multiplayer
    
- Execução determinística no backend
    

---

# 🧱 Estrutura de Dados

## Battle

-  id
    
-  status (ONGOING, FINISHED)
    
-  startTime
    
-  lastUpdateTime
    
-  unitA
    
-  unitB
    

---

## BattleUnit

-  id
    
-  hp
    
-  maxHp
    
-  attack
    
-  defense
    
-  attackSpeed (tempo entre ataques)
    
-  attackProgress (acumulador)
    
-  energy (0–100)
    
-  energyRegen (por segundo)
    
-  isDead
    

---

## Skill (simplificada)

-  id
    
-  damageMultiplier
    
-  energyCost (ex: 100)
    
-  target = enemy
    

---

# 🔁 Loop de Execução (CORE)

## Estratégia

Simulação baseada em **delta time** (tick-based).

---

## Método principal

-  Criar método:
    

```java
updateBattle(Battle battle, long deltaTime)
```

---

## Pipeline do loop

-  Para cada unidade viva:
    

### 1. Atualizar ataque básico

-  Incrementar `attackProgress += deltaTime`
    
-  Se `attackProgress >= attackSpeed`:
    
    -  Executar ataque básico
        
    -  Resetar `attackProgress`
        

---

### 2. Gerar energia

-  `energy += deltaTime * energyRegen`
    
-  Limitar em 100
    

---

### 3. Verificar uso de skill

-  Se `energy >= 100`:
    
    -  Executar skill
        
    -  Resetar energia
        

---

# ⚔️ Execução de Ataque Básico

-  Selecionar alvo (oponente direto)
    
-  Calcular dano:
    

```text
damage = attack - defense
(min: 1)
```

-  Aplicar dano
    
-  Se HP <= 0 → marcar como morto
    
-  Gerar energia adicional (opcional)
    

---

# 💥 Execução de Skill

-  Calcular dano:
    

```text
damage = attack * damageMultiplier
```

-  Aplicar no inimigo
    
-  Resetar energia
    

---

# 🧠 Controle de Tempo

## Opção 1 (MVP recomendado)

-  Simular sob demanda:
    
    - calcular `deltaTime = now - lastUpdateTime`
        
    - rodar `updateBattle`
        

## Opção 2 (futuro)

-  Loop contínuo (scheduler ou worker)
    

---

# 🏁 Finalização da batalha

-  Verificar após cada ação:
    

```text
if unitA.hp <= 0 → unitB vence
if unitB.hp <= 0 → unitA vence
```

-  Atualizar status = FINISHED
    

---

# 📡 Endpoint

## Criar batalha

-  `POST /battle/start`
    

## Atualizar batalha

-  `POST /battle/update`
    
    - calcula tempo decorrido
        
    - executa loop
        
    - retorna estado
        

---

# 📤 Response

```json
{
  "status": "ONGOING",
  "unitA": { "hp": 80, "energy": 40 },
  "unitB": { "hp": 65, "energy": 70 },
  "events": [
    { "type": "DAMAGE", "value": 10 },
    { "type": "SKILL", "value": 30 }
  ]
}
```

---

# 🧾 Battle Log (mínimo)

-  Criar estrutura:
    

```java
BattleEvent {
  type; // DAMAGE, SKILL
  sourceId;
  targetId;
  value;
}
```

---

# 💾 Persistência

-  Armazenar batalha em memória (MVP)
    
-  Opcional: usar Redis para batalhas ativas
    

---

# ⚠️ Regras importantes

-  Backend é a fonte da verdade
    
-  Nunca confiar no cliente
    
-  Execução deve ser determinística
    
-  Garantir que não haja execução concorrente da mesma batalha
    

---

# 🧪 Testes

-  Testar combate até morte
    
-  Testar uso de skill
    
-  Testar geração de energia
    
-  Testar limites (hp = 0, energy = 100)
    

---

# ✔️ Critérios de aceite

-  Batalha roda automaticamente sem input do usuário
    
-  Ataques acontecem com base em tempo
    
-  Skill é usada automaticamente ao atingir energia
    
-  Batalha finaliza corretamente
    
-  Estado consistente entre chamadas
    

---

# 🚀 Próximos passos (fora do escopo)

-  Buffs/debuffs
    
-  múltiplos personagens
    
-  auto-play avançado
    
-  animação baseada em battle log
    
-  sincronização com frontend Unity
    

---

# 🧠 Resultado esperado

Um motor simples de batalha contínua capaz de:

- simular combate automaticamente
    
- servir de base para expansão futura
    
- integrar facilmente com frontend (Unity)
    

---


