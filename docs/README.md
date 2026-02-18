# Monad User Guide

Welcome to **Monad**, your personal task management chatbot! Monad helps you manage todos, deadlines, events, and more—all via simple commands or a GUI.

---

## Adding Tasks
You can add todo tasks using the `todo` command. A todo task consists of a description.

**Command format:**

```bash
todo <description>
```

You can add deadlines using the `deadline` command. A deadline consists of a description and a date.

**Command format:**

```bash
deadline <description> /by <yyyy-mm-dd>
```
You can add event using the `event` command. An event consists of a description and two dates indicating the start and end datetime.

**Command format:**

```bash
event <description> /from <yyyy-mm-ddTHH:mm> /to <yyyy-mm-ddTHH:mm>
```

---

## Marking / Unmarking Tasks

You can mark or unmark a task is completed using the `mark` command. The command uses the index of the task.

**Command format:**

```bash
mark <index>
```

---
## Delete Task

You can delete a task using the `delete` command. The command uses the index of the task.

**Command format:**

```bash
delete <index>
```

---

## Find Task

You can search for a task using the `find` command. The command uses a keyword to search for.

**Command format:**

```bash
find <keyword>
```

---
## List Tasks

You can list of all tasks using the `list` command. The command does not require any parameters.

**Command format:**

```bash
list
```
---
## Sort Deadlines

You can sort deadlines by earliest to latest using the `sort` command. The command does not require any parameters.

**Command format:**

```bash
sort
```
---
