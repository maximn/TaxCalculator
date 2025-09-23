# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Scala-based tax calculation implementation that solves a progressive tax calculation challenge. The codebase consists of:

- **Main Implementation**: `src/main/scala/com/maxondev/TaxCalculator.scala` - Contains the core tax calculation logic using progressive tax brackets
- **Test Suite**: `src/test/scala/com/maxondev/TaxCalculatorTest.scala` - Comprehensive specs2-based tests

## Architecture

The `TaxCalculator` class implements a progressive tax system with predefined tax brackets stored as a sequence of `TaxForWindow` case classes. The calculation uses recursive pattern matching to apply appropriate tax rates across salary ranges.

## Development Commands

This project uses modern versions: **Scala 3.3.4**, **SBT 1.10.6**, and **specs2 5.5.6**. Compatible with Java 24+.

- **Compile**: `sbt compile`
- **Run Tests**: `sbt test`
- **Clean Build**: `sbt clean compile`
- **Interactive Mode**: `sbt` (then run commands like `test`, `compile`)

## Configuration Notes

- **JVM Options**: Project includes `.sbtopts` and `.jvmopts` files to handle Java 24+ compatibility
- **Forking**: Tests and runs are forked to properly apply JVM options
- **Warnings**: Some SBT/Scala runtime warnings may appear on Java 24+ (these are from the toolchain, not project code)

## Testing Framework

Uses specs2 5.5.6 for testing with built-in matchers for floating-point comparisons (`beCloseTo`).

## Key Components

- **TaxForWindow**: Case class defining tax brackets (from, to, percentage)
- **Progressive Calculation**: Recursive algorithm that applies tax rates cumulatively across brackets
- **Input Validation**: Requires non-negative salary input