def plus(one, other) {
    return one * other;
}

a = 1
b = 2
def c = plus(a, b)
log.info("calculate c=" + c)
log.info("cfg=" + cfg)
log.info("model=" + model)

def result = model.query(b)
log.info(result)
//log.info(model.type + " found!")
switch (model.type) {
    case "quote":
        log.info("quote section: ")
        break
    case "inquiry":
        log.info("inquiry section: ")
        break
    default:
        log.info("default section: " + model.type);
}
return result;