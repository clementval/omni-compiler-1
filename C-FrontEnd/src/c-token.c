#include "c-token.h"

const CTokenInfo s_CTokenInfos[] = {
    { "IDENTIFIER"                  , 258 },
    { "TYPENAME"                    , 259 },
    { "SCSPEC"                      , 260 },
    { "STATIC"                      , 261 },
    { "TYPESPEC"                    , 262 },
    { "TYPEQUAL"                    , 263 },
    { "CONSTANT"                    , 264 },
    { "STRING"                      , 265 },
    { "ELLIPSIS"                    , 266 },
    { "COLON_SQBRACKET"             , 267 },
    { "ENUM"                        , 268 },
    { "STRUCT"                      , 269 },
    { "UNION"                       , 270 },
    { "IF"                          , 271 },
    { "ELSE"                        , 272 },
    { "WHILE"                       , 273 },
    { "DO"                          , 274 },
    { "FOR"                         , 275 },
    { "SWITCH"                      , 276 },
    { "CASE"                        , 277 },
    { "DEFAULT"                     , 278 },
    { "BREAK"                       , 279 },
    { "CONTINUE"                    , 280 },
    { "RETURN"                      , 281 },
    { "GOTO"                        , 282 },
    { "SIZEOF"                      , 283 },
    { "ARITH_LE"                    , 284 },
    { "ARITH_GE"                    , 285 },
    { "ARITH_EQ"                    , 286 },
    { "ARITH_NE"                    , 287 },
    { "PRAGMA"                      , 288 },
    { "PRAGMA_ARG"                  , 289 },
    { "DIRECTIVE"                   , 290 },
    { "PRAGMA_PACK"                 , 291 },
    { "PRAGMA_EXEC"                 , 292 },
    { "PRAGMA_PREFIX"               , 293 },
    { "XMP_COARRAY_DECLARATION"     , 294 },
    { "XMP_CRITICAL"                , 295 },
    { "XMP_FUNC_CALL"               , 296 },
    { "ASSEMBLER"                   , 297 },
    { "LABEL"                       , 298 },
    { "REALPART"                    , 299 },
    { "IMAGPART"                    , 300 },
    { "ATTRIBUTE"                   , 301 },
    { "EXTENSION"                   , 302 },
    { "TYPEOF"                      , 303 },
    { "ALIGNOF"                     , 304 },
    { "BLTIN_OFFSETOF"              , 305 },
    { "BLTIN_VA_ARG"                , 306 },
    { "BLTIN_TYPES_COMPATIBLE_P"    , 307 },
    { "OROR"                        , 308 },
    { "ANDAND"                      , 309 },
    { "RSHIFT"                      , 310 },
    { "LSHIFT"                      , 311 },
    { "HYPERUNARY"                  , 312 },
    { "POINTSAT"                    , 313 },
    { "ASSIGN"                      , 314 },
    { "MINUSMINUS"                  , 315 },
    { "PLUSPLUS"                    , 316 },
    { "UNARY"                       , 317 },
};

