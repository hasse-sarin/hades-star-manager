# hades-star-manager

A [re-frame](https://github.com/Day8/re-frame) application to help manage Hades' Star play

## Development Mode

### Compile css:

Compile css file once.

```
lein garden once
```

Automatically recompile css file on change.

```
lein garden auto
```

### Run application:

```
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

## Production Build


To compile clojurescript to javascript:

```
lein clean
lein cljsbuild once min
```


## Local Docker support

```
First (devops me out):
  lein clean
  lein garden once
  lein cljsbuild once min
Build: 
  docker build -t <some-name> .
Run:
  docker run --name <some-name> -d -p 8080:80 <some-name>
```

should now be running in localhost:8080

## Google App Engine deployment (coming soon)