### Before you code
1. Run `npm i`
2. Rename matches of `my(-|_)backend` to the actual project name, according to the current item's naming policy for each of these:
```
shadow-cljs.edn
src/my_backend and children
```

### Development mode
Run `sh run.sh` and wait until the project builds. Then run `node public/js/index.js` to start the server.
shadow-cljs reflects code changes in the running server so there is no need to restart it.

### Building for production
Run `npx shadow-cljs release app` to generate an optimized build of the project. Then run `node public/js/index.js` to start the server.
