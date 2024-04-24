# Installing Clojure
## Quick start
1. Install Clojure on your system.
2. Install a JVM on your system.
3. Install an interactive development environment in your editor.

## Installing Clojure on your system
### MacOS with Homebrew
[Clojure]: https://clojure.org/

```shell
brew install clojure/tools/clojure
```

### Linux, Windows, and other OSs

For more information on installing Clojure, read the official [Clojure installation Guide].


[Clojure installation Guide]: https://clojure.org/guides/install_clojure

## Installing a JDK
Clojure runs on the Java Virtual Machine (JVM), meaning a Java Development Kit (JDK) build must be installed as well.
**If you already have a JDK installed, you can skip this step.**

If you are unsure, simply run:
`java --version`

We recommend using [Temurin] as it has a permissive license and is activly maintained.

### MacOS with Homebrew

To install the lastest LTS version:
```shel
brew install --cask temurin
```

To check if Temurin was installed correctly, run `java --version` in your terminal. You should expect to see the latest version of Temurin (21 as of March 4, 2024). If that's not the case, you may need to add `java` to your `PATH` as well.

[Temurin]: https://adoptium.net/en-GB/
[Java chapter in the official Clojure installation guide]: https://clojure.org/guides/install_clojure#java

### Linux, Windows, and other OSs
For more information on installing Temurin, read the official [Temurin installation Guide], or the [Java chapter in the official Clojure installation guide].

[Temurin installation guide]: https://adoptium.net/en-GB/installation/

## Run Clojure in VSCode with a REPL

In Clojure, you can run code instantly using a _Read-Eval-Print Loop_(REPL).

> The REPL is a tool for experimenting with code. It allows you to interact with a running program and quickly try out ideas. It does this by presenting you with a prompt where you can enter code. It then reads your input, evaluates it, prints the result, and loops, presenting you with a prompt again.

—[Brave Clojure, Chapter 1: Building, Running, and the REPL](https://www.braveclojure.com/getting-started/#Using_the_REPL)

To connect VSCode to the Clojure REPL, we recommend using the VSCode extension [Calva].

1. Install the [Calva extension] in VSCode
1. Navigate to the directory which host your Clojure code.
2. In the Command Palette (`Shift+Cmd+P` in VSCode), search for **Calva: Start a Project REPL and Connect**
3. For *Project Type*, select **deps.edn**
4. For alias, select **:dev**

This will make Calva start a REPL.
You can now run the individual functions you want in the code, using the REPL.

To run the tests from the REPL, go to the code you want to run, and place your cursor and evaluate it. The default keyboard shortcut to evaluate the current top level form in Calva is `option+enter`. You can read more about code evaluation in Calva [here](https://calva.io/eval-tips/).

[Calva]: https://calva.io
[Calva extension]: https://marketplace.visualstudio.com/items?itemName=betterthantomorrow.calva

## Running a REPL in other editors
If you prefer other editors, there are interactive development environments for many of them. The official Clojure website has a [comprehensive overview of extensions and plugins for different editors](https://clojure.org/guides/editors).
