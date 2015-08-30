# sbt-msx

An SBT plugin to compile [Mithril](http://lhorie.github.io/mithril/) templates via [MSX](https://github.com/insin/msx).

This plugin is heavily based on [sbt-dustjs-linkedin](https://github.com/jmparsons/sbt-dustjs-linkedin) created by [jmparsons](https://github.com/jmparsons)

## Installation

Add the sbt plugin to your `project/plugins.sbt` file:

    addSbtPlugin("com.roperzh.sbt" % "sbt-msx" % "0.0.1")

## Usage

#### Add your templates

Place your template **.msx** files anywhere inside of the `app/assets/` it will be available in the corresponding directory. If placed into `app/assets/templates/` the output would be `target/web/public/main/templates/`.

Pull in the generated javascript template file:

```html
<script src="@routes.Assets.at("templates/example.js")"></script>
```

## TODO

- Write tests

## Changelog

0.0.1 - August 30, 2015

- Inital release

## License
MIT: <http://opensource.org/licenses/MIT> - [@roperzh](http://www.roperzh.com)
