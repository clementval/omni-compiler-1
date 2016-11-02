/*
 * This class is generated by ./genXcodeJava.pl
 */
package exc.object;

import xcodeml.XmException;

//import xcodeml.c.binding.gen.*;
//import xcodeml.f.binding.gen.*;

public enum Xcode
{
    NULL                            (   0, 'L', null, null),
     // -----------------
     // FOR any list this must be first LIST
    LIST                            (   1, 'L', null, null),
     // -----------------
     // C: Terminal Node. DO NOT change.
    ID_LIST                         (   2, 'T', null, null),
    IDENT                           (   3, 'T', null, null),
    STRING_CONSTANT                 (   4, 'T', null, null),
    INT_CONSTANT                    (   5, 'T', null, null),
    FLOAT_CONSTANT                  (   6, 'T', null, null),
    LONGLONG_CONSTANT               (   7, 'T', null, null),
    MOE_CONSTANT                    (   8, 'T', null, null),
     // -----------------
     // C: Declaration / Definition
    FUNCTION_DEFINITION             (   9, 'L', null, null),
    VAR_DECL                        (  10, 'L', null, null),
    FUNCTION_DECL                   (  11, 'L', null, null),
     // -----------------
     // C: Statement
    COMPOUND_STATEMENT              (  12, 'S', null, null),
    EXPR_STATEMENT                  (  13, 'S', null, null),
    WHILE_STATEMENT                 (  14, 'S', null, null),
    DO_STATEMENT                    (  15, 'S', null, null),
    FOR_STATEMENT                   (  16, 'S', null, null),
    IF_STATEMENT                    (  17, 'S', null, null),
    SWITCH_STATEMENT                (  18, 'S', null, null),
    BREAK_STATEMENT                 (  19, 'S', null, null),
    RETURN_STATEMENT                (  20, 'S', null, null),
    GOTO_STATEMENT                  (  21, 'S', null, null),
    CONTINUE_STATEMENT              (  22, 'S', null, null),
    STATEMENT_LABEL                 (  23, 'S', null, null),
    CASE_LABEL                      (  24, 'S', null, null),
    DEFAULT_LABEL                   (  25, 'S', null, null),
     // -----------------
     // C: Expression
    CONDITIONAL_EXPR                (  26, 'L', null, null),
    COMMA_EXPR                      (  27, 'L', null, null),
    ASSIGN_EXPR                     (  28, 'A', null, null),
    PLUS_EXPR                       (  29, 'B', null, null),
    ASG_PLUS_EXPR                   (  30, 'A', null, null),
    MINUS_EXPR                      (  31, 'B', null, null),
    ASG_MINUS_EXPR                  (  32, 'A', null, null),
    UNARY_MINUS_EXPR                (  33, 'U', null, null),
    MUL_EXPR                        (  34, 'B', null, null),
    ASG_MUL_EXPR                    (  35, 'A', null, null),
    DIV_EXPR                        (  36, 'B', null, null),
    ASG_DIV_EXPR                    (  37, 'A', null, null),
    MOD_EXPR                        (  38, 'B', null, null),
    ASG_MOD_EXPR                    (  39, 'A', null, null),
    LSHIFT_EXPR                     (  40, 'B', null, null),
    ASG_LSHIFT_EXPR                 (  41, 'A', null, null),
    RSHIFT_EXPR                     (  42, 'B', null, null),
    ASG_RSHIFT_EXPR                 (  43, 'A', null, null),
    BIT_AND_EXPR                    (  44, 'B', null, null),
    ASG_BIT_AND_EXPR                (  45, 'A', null, null),
    BIT_OR_EXPR                     (  46, 'B', null, null),
    ASG_BIT_OR_EXPR                 (  47, 'A', null, null),
    BIT_XOR_EXPR                    (  48, 'B', null, null),
    ASG_BIT_XOR_EXPR                (  49, 'A', null, null),
    BIT_NOT_EXPR                    (  50, 'U', null, null),
    DESIGNATED_VALUE                (  51, 'L', null, null),
    COMPOUND_VALUE                  (  52, 'L', null, null),
    COMPOUND_VALUE_ADDR             (  53, 'L', null, null),
     // -----------------
     // C: Logical Expression
    LOG_EQ_EXPR                     (  54, 'B', null, null),
    LOG_NEQ_EXPR                    (  55, 'B', null, null),
    LOG_GE_EXPR                     (  56, 'B', null, null),
    LOG_GT_EXPR                     (  57, 'B', null, null),
    LOG_LE_EXPR                     (  58, 'B', null, null),
    LOG_LT_EXPR                     (  59, 'B', null, null),
    LOG_AND_EXPR                    (  60, 'B', null, null),
    LOG_OR_EXPR                     (  61, 'B', null, null),
    LOG_NOT_EXPR                    (  62, 'U', null, null),
     // -----------------
     // C: Primary Expression
    FUNCTION_CALL                   (  63, 'P', null, null),
    POINTER_REF                     (  64, 'P', null, null),
    SIZE_OF_EXPR                    (  65, 'P', null, null),
    CAST_EXPR                       (  66, 'P', null, null),
    PRE_INCR_EXPR                   (  67, 'P', null, null),
    PRE_DECR_EXPR                   (  68, 'P', null, null),
    POST_INCR_EXPR                  (  69, 'A', null, null),
    POST_DECR_EXPR                  (  70, 'A', null, null),
    ADDR_OF                         (  71, 'P', null, null),
    TYPE_NAME                       (  72, 'L', null, null),
     // -----------------
     // C: Symbol Reference
    VAR                             (  73, 'T', null, null),
    VAR_ADDR                        (  74, 'T', null, null),
    ARRAY_ADDR                      (  75, 'T', null, null),
    FUNC_ADDR                       (  76, 'T', null, null),
    MEMBER_REF                      (  77, 'P', null, null),
    MEMBER_ARRAY_REF                (  78, 'L', null, null),
    MEMBER_ADDR                     (  79, 'L', null, null),
    MEMBER_ARRAY_ADDR               (  80, 'L', null, null),
    ARRAY_REF                       (  81, 'L', null, null),
     // L   ARRAY_AREF
     // -----------------
     // C: Directive
    PRAGMA_LINE                     (  82, 'L', null, null),
    TEXT                            (  83, 'L', null, null),
     // -----------------
     // C: GCC Syntax
    BUILTIN_OP                      (  84, 'L', null, null),
    GCC_ATTRIBUTES                  (  85, 'L', null, null),
    GCC_ATTRIBUTE                   (  86, 'L', null, null),
    GCC_ASM                         (  87, 'L', null, null),
    GCC_ASM_DEFINITION              (  88, 'L', null, null),
    GCC_ASM_STATEMENT               (  89, 'L', null, null),
    GCC_ASM_OPERANDS                (  90, 'L', null, null),
    GCC_ASM_OPERAND                 (  91, 'L', null, null),
    GCC_ASM_CLOBBERS                (  92, 'L', null, null),
    GCC_ALIGN_OF_EXPR               (  93, 'L', null, null),
    GCC_MEMBER_DESIGNATOR           (  94, 'L', null, null),
    GCC_LABEL_ADDR                  (  95, 'L', null, null),
    GCC_COMPOUND_EXPR               (  96, 'L', null, null),
    GCC_RANGED_CASE_LABEL           (  97, 'L', null, null),
     // -----------------
     // C: XcalableMP Syntax
    SUB_ARRAY_REF                   (  98, 'L', null, null),
     // L   SUBA_LOWER_BOUND
     // L   SUBA_UPPER_BOUND
     // L   SUBA_STEP
    CO_ARRAY_REF                    (  99, 'L', null, null),
    CO_ARRAY_ASSIGN_EXPR            ( 100, 'L', null, null),   // not used??
     // -----------------
     // Fortran: Declaration / Definition
    F_DATA_DECL                     ( 101, 'L', null, null),
    F_BLOCK_DATA_DEFINITION         ( 102, 'L', null, null),
    F_ENTRY_DECL                    ( 103, 'L', null, null),
    F_EXTERN_DECL                   ( 104, 'L', null, null),
    F_EQUIVALENCE_DECL              ( 105, 'L', null, null),
    F_COMMON_DECL                   ( 106, 'L', null, null),
    F_MODULE_DEFINITION             ( 107, 'L', null, null),
    F_MODULE_PROCEDURE_DECL         ( 108, 'L', null, null),
    F_INTERFACE_DECL                ( 109, 'L', null, null),
    F_FORMAT_DECL                   ( 110, 'L', null, null),
    F_NAMELIST_DECL                 ( 111, 'L', null, null),
    F_STRUCT_DECL                   ( 112, 'L', null, null),
    F_USE_DECL                      ( 113, 'L', null, null),
    F_RENAME                        ( 114, 'L', null, null),
    F_RENAMABLE                     ( 115, 'L', null, null),
    F_USE_ONLY_DECL                 ( 116, 'L', null, null),
    F_STATEMENT_LIST                ( 117, 'L', null, null),
     // -----------------
     // Fortran: Statement
    F_ASSIGN_STATEMENT              ( 118, 'S', null, null),
    F_POINTER_ASSIGN_STATEMENT      ( 119, 'S', null, null),
    F_DO_STATEMENT                  ( 120, 'S', null, null),
    F_DO_WHILE_STATEMENT            ( 121, 'S', null, null),
    F_SELECT_CASE_STATEMENT         ( 122, 'S', null, null),
    F_CASE_LABEL                    ( 123, 'S', null, null),
    F_WHERE_STATEMENT               ( 124, 'S', null, null),
    F_IF_STATEMENT                  ( 125, 'S', null, null),
    F_CYCLE_STATEMENT               ( 126, 'S', null, null),
    F_EXIT_STATEMENT                ( 127, 'S', null, null),
    F_CONTINUE_STATEMENT            ( 128, 'S', null, null),
    F_CONTAINS_STATEMENT            ( 129, 'S', null, null),
    F_ALLOCATE_STATEMENT            ( 130, 'S', null, null),
    F_BACKSPACE_STATEMENT           ( 131, 'S', null, null),
    F_CLOSE_STATEMENT               ( 132, 'S', null, null),
    F_DEALLOCATE_STATEMENT          ( 133, 'S', null, null),
    F_END_FILE_STATEMENT            ( 134, 'S', null, null),
    F_INQUIRE_STATEMENT             ( 135, 'S', null, null),
    F_NULLIFY_STATEMENT             ( 136, 'S', null, null),
    F_OPEN_STATEMENT                ( 137, 'S', null, null),
    F_PRINT_STATEMENT               ( 138, 'S', null, null),
    F_READ_STATEMENT                ( 139, 'S', null, null),
    F_REWIND_STATEMENT              ( 140, 'S', null, null),
    F_WRITE_STATEMENT               ( 141, 'S', null, null),
    F_PAUSE_STATEMENT               ( 142, 'S', null, null),
    F_STOP_STATEMENT                ( 143, 'S', null, null),
     // -----------------
     // Fortran: Variable Reference
    F_VAR_REF                       ( 144, 'L', null, null),
    F_ARRAY_REF                     ( 145, 'L', null, null),
     // -----------------
     // Unary Expression
    F_USER_UNARY_EXPR               ( 146, 'U', null, null),
     // -----------------
     // Fortran: Binary Expression
    F_POWER_EXPR                    ( 147, 'B', null, null),
    F_LOG_EQV_EXPR                  ( 148, 'B', null, null),
    F_LOG_NEQV_EXPR                 ( 149, 'B', null, null),
    F_USER_BINARY_EXPR              ( 150, 'B', null, null),
     // -----------------
     // Fortran: Character Expression
    F_CHARACTER_REF                 ( 151, 'L', null, null),
    F_CONCAT_EXPR                   ( 152, 'L', null, null),
     // -----------------
     // Fortran: Constant Expression
    F_LOGICAL_CONSTATNT             ( 153, 'T', null, null),
    F_CHARACTER_CONSTATNT           ( 154, 'T', null, null),
    F_COMPLEX_CONSTATNT             ( 155, 'L', null, null),
     // -----------------
     // Fortran: Other Expression
    F_ARRAY_CONSTRUCTOR             ( 156, 'L', null, null),
    F_STRUCT_CONSTRUCTOR            ( 157, 'L', null, null),
     // -----------------
     // Fortran: Other Elements
    F_VAR_LIST                      ( 158, 'L', null, null),
    F_VALUE_LIST                    ( 159, 'L', null, null),
    F_VALUE                         ( 160, 'L', null, null),
    F_DO_LOOP                       ( 161, 'L', null, null),
    F_INDEX_RANGE                   ( 162, 'L', null, null),
    F_ALLOC                         ( 163, 'L', null, null),
    F_ARRAY_INDEX                   ( 164, 'L', null, null),
    F_CONDITION                     ( 165, 'L', null, null),
    F_NAMED_VALUE                   ( 166, 'L', null, null),
    F_NAMED_VALUE_LIST              ( 167, 'L', null, null),
     // -----------------
     // External Pragma
    OMP_PRAGMA                      ( 168, 'L', null, null),
     // -----------------
     // OpenMP Code Transformation
    OMP_PARALLEL                    ( 169, 'L', null, null),
    OMP_FORALL                      ( 170, 'L', null, null),
    OMP_SECTIONS                    ( 171, 'L', null, null),
    OMP_SINGLE                      ( 172, 'L', null, null),
    OMP_MASTER                      ( 173, 'L', null, null),
    OMP_CRITICAL                    ( 174, 'L', null, null),
    OMP_ORDERED                     ( 175, 'L', null, null),
    OMP_ATOMIC                      ( 176, 'L', null, null),
    OMP_BARRIER                     ( 177, 'L', null, null),
    OMP_FLUSH                       ( 178, 'L', null, null),
    OMP_SETARG                      ( 179, 'L', null, null),
    OMP_GETARG                      ( 180, 'L', null, null),
    OMP_BCAST                       ( 181, 'L', null, null),
    OMP_BCAST_THDPRV                ( 182, 'L', null, null),
    OMP_SHARE                       ( 183, 'L', null, null),
    OMP_REDUCTION                   ( 184, 'L', null, null),
    OMP_LAST_UPDATE                 ( 185, 'L', null, null),
    OMP_SCHEDULE					( 186, 'L', null, null),
     // -----------------
     // Using Internally
    STRING                          ( 187, 'T', null, null),
     // -----------------
     // register, temporary variable generated by compiler
    REG                             ( 188, 'T', null, null),
     // -----------------
     // join operator in SSA
    JOIN                            ( 189, 'B', null, null),
     // -----------------
     // XcalableMP Pragma
    XMP_PRAGMA                      ( 190, 'L', null, null),
    XMP_DESC_OF                     ( 191, 'U', null, null),
     // -----------------
     // OpenACC Pragma
    ACC_PRAGMA                      ( 192, 'L', null, null),
     // -----------------
    INDEX_RANGE                     ( 193, 'L', null, null),
    LOWER_BOUND                     ( 194, 'L', null, null),
    UPPER_BOUND                     ( 195, 'L', null, null),
    STEP                            ( 196, 'L', null, null),
     // -----------------
     // added for coarray
    F_CO_SHAPE                      ( 197, 'L', null, null),         // ID=060
     // -----------------
     // Fortran2008: SYNCXX, CRITICAL, LOCK.
    F_SYNCALL_STATEMENT             ( 198, 'S', null, null),
    F_SYNCIMAGE_STATEMENT           ( 199, 'S', null, null),
    F_SYNCMEMORY_STATEMENT          ( 200, 'S', null, null),
    F_CRITICAL_STATEMENT            ( 201, 'S', null, null),
    F_LOCK_STATEMENT                ( 202, 'S', null, null),
    F_UNLOCK_STATEMENT              ( 203, 'S', null, null),
    F_SYNC_STAT                     ( 204, 'L', null, null),
     // C++11
    CPP_DECL_NAMESPACE              ( 205, 'L', null, null),
    CPP_CLASS_DECL                  ( 206, 'L', null, null),
    CPP_CONSTRUCT_EXPR_CLASS_STATEMENT
                                    ( 207, 'L', null, null),
    CPP_THIS_EXPR                   ( 208, 'L', null, null),
    ID                              ( 209, 'T', null, null),
    CPP_NESTEDNAMESPECIFIER_TYPESPEC( 210, 'L', null, null),
     // Fortran2008: BLOCK, VOLATILE.
    F_BLOCK_STATEMENT               ( 211, 'L', null, null),
     // C++11
    CPP_CONST_CAST_EXPR             ( 212, 'L', null, null),
    CPP_STATIC_CAST_EXPR            ( 213, 'L', null, null),
    CPP_REINTERPRET_CAST_EXPR       ( 214, 'L', null, null),
    CPP_DYNAMIC_CAST_EXPR           ( 215, 'L', null, null),
    CPP_OPERATOR_ADDR               ( 216, 'T', null, null),
    CPP_TRY_STATEMENT               ( 217, 'L', null, null),
    CPP_THROW_STATEMENT             ( 218, 'L', null, null),
    CPP_CATCH_STATEMENT             ( 219, 'L', null, null),
     // Fortran2008: PARAMETERIZED DERIVED TYPE.
    F_TYPE_PARAM                    ( 220, 'L', null, null),
    F_TYPE_PARAMS                   ( 221, 'L', null, null),
    F_TYPE_PARAM_VALUES             ( 222, 'L', null, null),
    F_LEN                           ( 223, 'L', null, null),
     // Fortran2003: IMPORT Statement
    F_IMPORT_STATEMENT              ( 224, 'L', null, null ),
     // Fortran2003: SELECT TYPE
    SELECT_TYPE_STATEMENT           ( 225, 'L', null, null),
    TYPE_GUARD                      ( 226, 'L', null, null),

     // Codes dynamically assignable
    DYN_1                           ( 1001, 'L', null, null),
    DYN_2                           ( 1002, 'L', null, null),
    DYN_3                           ( 1003, 'L', null, null),
    DYN_4                           ( 1004, 'L', null, null),
    DYN_5                           ( 1005, 'L', null, null),
    DYN_6                           ( 1006, 'L', null, null),
    DYN_7                           ( 1007, 'L', null, null),
    DYN_8                           ( 1008, 'L', null, null),
    DYN_9                           ( 1009, 'L', null, null),
    DYN_10                          ( 1010, 'L', null, null),
    DYN_11                          ( 1011, 'L', null, null),
    DYN_12                          ( 1012, 'L', null, null),
    DYN_13                          ( 1013, 'L', null, null),
    DYN_14                          ( 1014, 'L', null, null),
    DYN_15                          ( 1015, 'L', null, null),
    DYN_16                          ( 1016, 'L', null, null),
    DYN_17                          ( 1017, 'L', null, null),
    DYN_18                          ( 1018, 'L', null, null),
    DYN_19                          ( 1019, 'L', null, null),
    DYN_20                          ( 1020, 'L', null, null),
    DYN_21                          ( 1021, 'L', null, null),
    DYN_22                          ( 1022, 'L', null, null),
    DYN_23                          ( 1023, 'L', null, null),
    DYN_24                          ( 1024, 'L', null, null),
    DYN_25                          ( 1025, 'L', null, null),
    DYN_26                          ( 1026, 'L', null, null),
    DYN_27                          ( 1027, 'L', null, null),
    DYN_28                          ( 1028, 'L', null, null),
    DYN_29                          ( 1029, 'L', null, null),
    DYN_30                          ( 1030, 'L', null, null),
    DYN_31                          ( 1031, 'L', null, null),
    DYN_32                          ( 1032, 'L', null, null),
    DYN_33                          ( 1033, 'L', null, null),
    DYN_34                          ( 1034, 'L', null, null),
    DYN_35                          ( 1035, 'L', null, null),
    DYN_36                          ( 1036, 'L', null, null),
    DYN_37                          ( 1037, 'L', null, null),
    DYN_38                          ( 1038, 'L', null, null),
    DYN_39                          ( 1039, 'L', null, null),
    DYN_40                          ( 1040, 'L', null, null),
    DYN_41                          ( 1041, 'L', null, null),
    DYN_42                          ( 1042, 'L', null, null),
    DYN_43                          ( 1043, 'L', null, null),
    DYN_44                          ( 1044, 'L', null, null),
    DYN_45                          ( 1045, 'L', null, null),
    DYN_46                          ( 1046, 'L', null, null),
    DYN_47                          ( 1047, 'L', null, null),
    DYN_48                          ( 1048, 'L', null, null),
    DYN_49                          ( 1049, 'L', null, null),
    DYN_50                          ( 1050, 'L', null, null),
    DYN_51                          ( 1051, 'L', null, null),
    DYN_52                          ( 1052, 'L', null, null),
    DYN_53                          ( 1053, 'L', null, null),
    DYN_54                          ( 1054, 'L', null, null),
    DYN_55                          ( 1055, 'L', null, null),
    DYN_56                          ( 1056, 'L', null, null),
    DYN_57                          ( 1057, 'L', null, null),
    DYN_58                          ( 1058, 'L', null, null),
    DYN_59                          ( 1059, 'L', null, null),
    DYN_60                          ( 1060, 'L', null, null),
    DYN_61                          ( 1061, 'L', null, null),
    DYN_62                          ( 1062, 'L', null, null),
    DYN_63                          ( 1063, 'L', null, null),
    DYN_64                          ( 1064, 'L', null, null),
    DYN_65                          ( 1065, 'L', null, null),
    DYN_66                          ( 1066, 'L', null, null),
    DYN_67                          ( 1067, 'L', null, null),
    DYN_68                          ( 1068, 'L', null, null),
    DYN_69                          ( 1069, 'L', null, null),
    DYN_70                          ( 1070, 'L', null, null),
    DYN_71                          ( 1071, 'L', null, null),
    DYN_72                          ( 1072, 'L', null, null),
    DYN_73                          ( 1073, 'L', null, null),
    DYN_74                          ( 1074, 'L', null, null),
    DYN_75                          ( 1075, 'L', null, null),
    DYN_76                          ( 1076, 'L', null, null),
    DYN_77                          ( 1077, 'L', null, null),
    DYN_78                          ( 1078, 'L', null, null),
    DYN_79                          ( 1079, 'L', null, null),
    DYN_80                          ( 1080, 'L', null, null),
    DYN_81                          ( 1081, 'L', null, null),
    DYN_82                          ( 1082, 'L', null, null),
    DYN_83                          ( 1083, 'L', null, null),
    DYN_84                          ( 1084, 'L', null, null),
    DYN_85                          ( 1085, 'L', null, null),
    DYN_86                          ( 1086, 'L', null, null),
    DYN_87                          ( 1087, 'L', null, null),
    DYN_88                          ( 1088, 'L', null, null),
    DYN_89                          ( 1089, 'L', null, null),
    DYN_90                          ( 1090, 'L', null, null),
    DYN_91                          ( 1091, 'L', null, null),
    DYN_92                          ( 1092, 'L', null, null),
    DYN_93                          ( 1093, 'L', null, null),
    DYN_94                          ( 1094, 'L', null, null),
    DYN_95                          ( 1095, 'L', null, null),
    DYN_96                          ( 1096, 'L', null, null),
    DYN_97                          ( 1097, 'L', null, null),
    DYN_98                          ( 1098, 'L', null, null),
    DYN_99                          ( 1099, 'L', null, null),
    DYN_100                         ( 1100, 'L', null, null),
     // EOF
    ;

    private static final int ASSIGN_START_NUM = 1001;
    private int int_val;
    private char kind;
    private Class<?> xmc_class, xmf_class;
    private static int assign_index = ASSIGN_START_NUM;

    private Xcode(int int_val, char kind, Class<?> xmc_class, Class<?> xmf_class)
    {
        this.int_val = int_val;
        this.kind = kind;
        this.xmc_class = xmc_class;
        this.xmf_class = xmf_class;
    }

    public int toInt()
    {
        return int_val;
    }

    public String toXcodeString()
    {
        return toString();
    }

    public static Xcode assign() throws XmException
    {
        Xcode x = get(assign_index++);
        if(x == null)
            throw new XmException("too many Xcode assigned.");
        return x;
    }

    public static Xcode get(int intVal)
    {
        for(Xcode x : values()) {
            if(x.toInt() == intVal)
                return x;
        }
        return null;
    }

    public Class<?> getXcodeML_C_Class()
    {
        return xmc_class;
    }

    public Class<?> getXcodeML_F_Class()
    {
        return xmf_class;
    }

    public boolean isBuiltinCode()
    {
        return toInt() < ASSIGN_START_NUM;
    }

    public boolean isAssignedCode()
    {
        return !isBuiltinCode();
    }

    /** return true if this object is binary operation. */
    public boolean isBinaryOp()
    {
        return kind == 'B';
    }

    /** return true if this object is unary operation. */
    public boolean isUnaryOp()
    {
        return kind == 'U';
    }

    /** return ture if this object is an assignment with binary operation */
    public boolean isAsgOp()
    {
        return kind == 'A';
    }

    /** return true if this object is a terminal object */
    public boolean isTerminal()
    {
        return kind == 'T';
    }

    public boolean isFstatement()
    {
        switch(this) {
        case RETURN_STATEMENT:              case GOTO_STATEMENT:
        case F_DO_STATEMENT:                case F_DO_WHILE_STATEMENT:
        case F_IF_STATEMENT:                case F_WHERE_STATEMENT:
        case F_SELECT_CASE_STATEMENT:       case STATEMENT_LABEL:
        case F_CASE_LABEL:
        case F_ASSIGN_STATEMENT:            case F_POINTER_ASSIGN_STATEMENT:
        case F_CYCLE_STATEMENT:             case F_EXIT_STATEMENT:
        case F_CONTINUE_STATEMENT:
        case F_ALLOCATE_STATEMENT:          case F_BACKSPACE_STATEMENT:
        case F_CLOSE_STATEMENT:             case F_DEALLOCATE_STATEMENT:
        case F_END_FILE_STATEMENT:          case F_INQUIRE_STATEMENT:
        case F_NULLIFY_STATEMENT:           case F_OPEN_STATEMENT:
        case F_PRINT_STATEMENT:             case F_READ_STATEMENT:
        case F_REWIND_STATEMENT:            case F_WRITE_STATEMENT:
        case F_PAUSE_STATEMENT:             case F_STOP_STATEMENT:
        case F_ENTRY_DECL:                  case F_FORMAT_DECL:
        case F_DATA_DECL:
        case PRAGMA_LINE:                   case TEXT:
        case F_SYNCALL_STATEMENT:           case F_SYNCIMAGE_STATEMENT:
        case F_SYNCMEMORY_STATEMENT:        case F_CRITICAL_STATEMENT:
        case F_LOCK_STATEMENT:              case F_UNLOCK_STATEMENT:
        case F_BLOCK_STATEMENT:
        case SELECT_TYPE_STATEMENT:         case TYPE_GUARD:
            return true;
        }
        return false;
    }

    public boolean isDefinition()
    {
        switch(this) {
        case FUNCTION_DEFINITION:
        case F_MODULE_DEFINITION:
            return true;
        }
        return false;
    }
}
